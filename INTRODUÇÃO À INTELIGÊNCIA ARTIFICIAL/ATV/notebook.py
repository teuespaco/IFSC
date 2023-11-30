# -*- coding: utf-8 -*-

import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.preprocessing import LabelEncoder, StandardScaler
from sklearn.model_selection import train_test_split
import pickle
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier  
from sklearn.neighbors import KNeighborsClassifier
from sklearn.svm import SVC
from sklearn.naive_bayes import GaussianNB
from sklearn.neural_network import MLPClassifier


base_votacao = pd.read_csv('votacao.csv')

# Explorando  dados
base_votacao.head(10)
base_votacao.tail(5)
base_votacao.describe()

# Filtrando os dados por 'Class Name'
republican_data = base_votacao[base_votacao['Class Name'] == 'republican']
democrat_data = base_votacao[base_votacao['Class Name'] == 'democrat']

class_name_counts = base_votacao['Class Name'].value_counts()
sns.countplot(x=base_votacao['Class Name'])

# Atributos do minha base
attributes_to_plot = [
    'handicapped-infants', 'water-project-cost-sharing', 
    'adoption-of-the-budget-resolution', 'physician-fee-freeze', 
    'el-salvador-aid', 'religious-groups-in-schools', 
    'anti-satellite-test-ban', 'aid-to-nicaraguan-contras', 
    'mx-missile', 'immigration', 'synfuels-corporation-cutback', 
    'education-spending', 'superfund-right-to-sue', 'crime', 
    'duty-free-exports', 'export-administration-act-south-africa'
]

for attr in attributes_to_plot:
    plt.hist(x=base_votacao[attr])

sns.pairplot(base_votacao, vars=attributes_to_plot)

# Tratamento de dados inconsistentes
base_votacao.replace('?', pd.NA, inplace=True)
base_votacao.dropna(inplace=True)

# Pré-processamento

X_voto = base_votacao.iloc[:, 1:].values
y_voto = base_votacao.iloc[:, 0].values

# Transformando 'n' para 0 e 'y' para 1
X_voto[X_voto == 'n'] = 0
X_voto[X_voto == 'y'] = 1

X_voto = X_voto.astype(float)
label_encoder = LabelEncoder()
y_voto = label_encoder.fit_transform(y_voto)

# Escalonamento dos valores
scaler_votos = StandardScaler()
X_voto = scaler_votos.fit_transform(X_voto)

# Divisão entre base de treinamento e testes
X_voto_treinamento, X_voto_teste, y_voto_treinamento, y_voto_teste = train_test_split(X_voto, y_voto, test_size=0.25, random_state=0)

# Salvar variáveis
with open('votos.pkl', mode='wb') as f:
    pickle.dump([X_voto_treinamento, y_voto_treinamento, X_voto_teste, y_voto_teste], f)

# Naive Bayes

# Criar uma instância do classificador Naive Bayes
naive_bayes_classifier = GaussianNB()

# Treinar o classificador com os dados de treinamento
naive_bayes_classifier.fit(X_voto_treinamento, y_voto_treinamento)

# Fazer previsões
y_pred = naive_bayes_classifier.predict(X_voto_teste)

# Avaliar o desempenho do classificador
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

# Calcular a precisão
precisao = accuracy_score(y_voto_teste, y_pred)

# Exibir outras métricas de avaliação, como matriz de confusão e relatório de classificação
matriz_confusao = confusion_matrix(y_voto_teste, y_pred)
print('Matriz de Confusao:')
print(matriz_confusao)

relatorio_classificacao = classification_report(y_voto_teste, y_pred)
print('Relatorio de Classificacao:')
print(relatorio_classificacao)

porcentagem_precisao = precisao * 100
print(f'Precisao Naive Bayes: {porcentagem_precisao:.2f}%')  # 91,38%

# Decision Tree

# Criar uma instância do classificador Decision Tree
decision_tree_classifier = DecisionTreeClassifier(random_state=0)

# Treinar o classificador com os dados de treinamento
decision_tree_classifier.fit(X_voto_treinamento, y_voto_treinamento)

# Fazer previsões
y_pred_decision_tree = decision_tree_classifier.predict(X_voto_teste)

# Avaliar o desempenho do classificador
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

# Calcular a precisão
precisao_decision_tree = accuracy_score(y_voto_teste, y_pred_decision_tree)

# Exibir outras métricas de avaliação, como matriz de confusão e relatório de classificação
matriz_confusao_decision_tree = confusion_matrix(y_voto_teste, y_pred_decision_tree)
print('Matriz de Confusao:')
print(matriz_confusao_decision_tree)

relatorio_classificacao_decision_tree = classification_report(y_voto_teste, y_pred_decision_tree)
print('Relatorio de Classificacao:')
print(relatorio_classificacao_decision_tree)

porcentagem_precisao = precisao_decision_tree * 100
print(f'Precisao Decision Tree: {porcentagem_precisao:.2f}%') #93,10


# Random Forest

# Criar uma instância do classificador Random Forest
random_forest_classifier = RandomForestClassifier(random_state=0)

# Treinar o classificador com os dados de treinamento
random_forest_classifier.fit(X_voto_treinamento, y_voto_treinamento)

# Fazer previsões
y_pred_random_forest = random_forest_classifier.predict(X_voto_teste)

# Avaliar o desempenho do classificador 
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

# Calcular a precisão
precisao_random_forest = accuracy_score(y_voto_teste, y_pred_random_forest)

# Exibir outras métricas de avaliação, como matriz de confusão e relatório de classificação
matriz_confusao_random_forest = confusion_matrix(y_voto_teste, y_pred_random_forest)
print('Matriz de Confusao:')
print(matriz_confusao_random_forest)

relatorio_classificacao_random_forest = classification_report(y_voto_teste, y_pred_random_forest)
print('Relatorio de Classificacao:')
print(relatorio_classificacao_random_forest)

porcentagem_precisao = precisao_random_forest * 100

# KNN

# Criar uma instância do classificador
knn_classifier = KNeighborsClassifier(n_neighbors=5)

# Treinar o classificador com os dados de treinamento
knn_classifier.fit(X_voto_treinamento, y_voto_treinamento)

# Fazer previsões
y_pred_knn = knn_classifier.predict(X_voto_teste)

# Calcular a precisão
precisao_knn = accuracy_score(y_voto_teste, y_pred_knn)


porcentagem_precisao = precisao_knn * 100

#SVM
# Criar uma instância do classificador SVM
svm_classifier = SVC(kernel='linear', random_state=0)  

# Treinar o classificador SVM com os dados de treinamento
svm_classifier.fit(X_voto_treinamento, y_voto_treinamento)

# Fazer previsões
y_pred_svm = svm_classifier.predict(X_voto_teste)

# Calcular a precisão das previsões
precisao_svm = accuracy_score(y_voto_teste, y_pred_svm)

porcentagem_precisao = precisao_svm * 100

#Redes Neurais
# Criar uma instância do classificador 
rna_classifier = MLPClassifier(hidden_layer_sizes=(100,), max_iter=1000, random_state=0)

# Treinar o classificador SVM com os dados de treinamento
rna_classifier.fit(X_voto_treinamento, y_voto_treinamento)

# Fazer previsões
y_pred_rna = rna_classifier.predict(X_voto_teste)

# Calcular a precisão das previsões
precisao_rna = accuracy_score(y_voto_teste, y_pred_rna)

porcentagem_precisao = precisao_rna * 100


#Grafico
# Calcula a precisão de cada classificador
precisao_naive_bayes = accuracy_score(y_voto_teste, y_pred)
precisao_decision_tree = precisao_decision_tree
precisao_random_forest = precisao_random_forest
precisao_knn = precisao_knn
precisao_svm = precisao_svm
precisao_rna = precisao_rna


# Nomes dos classificadores
classificadores = ['Naive Bayes', 'Decision Tree', 'Random Forest', 'KNN', 'SVM', 'Redes Neurais']

# Valores de precisão correspondentes
precisoes = [precisao_naive_bayes, precisao_decision_tree, precisao_random_forest, precisao_knn, precisao_svm, precisao_rna]

# Grafico
plt.figure(figsize=(10, 6))
plt.bar(classificadores, precisoes, color=['blue', 'green', 'red', 'purple', 'orange', 'black'])
plt.xlabel('Classificadores')
plt.ylabel('Precisão')
plt.title('Comparação de Precisão entre Classificadores')
plt.ylim(0.85, 1.0)  
plt.show()

print(f'+----------------------------------+')
porcentagem_precisao = precisao * 100
print(f'|   Precisao Naive Bayes: {porcentagem_precisao:.2f}%   |')

porcentagem_precisao = precisao_decision_tree * 100
print(f'|   Precisao Decision Tree: {porcentagem_precisao:.2f}% |')

porcentagem_precisao = precisao_random_forest * 100
print(f'|   Precisão Random Forest: {porcentagem_precisao:.2f}% |')

porcentagem_precisao = precisao_knn * 100
print(f'|   Precisão KNN: {porcentagem_precisao:.2f}%           |')

porcentagem_precisao = precisao_svm * 100
print(f'|   Precisão SVM: {porcentagem_precisao:.2f}%           |')

porcentagem_precisao = precisao_rna * 100
print(f'|   Precisão RNA: {porcentagem_precisao:.2f}%           |')

print(f'+----------------------------------+')













