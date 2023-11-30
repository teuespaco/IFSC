from flask import Flask, request, jsonify

app = Flask(__name__)

# Estrutura de dados para armazenar os dados temporariamente
dados_do_sensor = []

# Rota para receber dados do Cliente 1
@app.route('/dados', methods=['POST'])
def receber_dados():
    dados = request.json
    dado_id = dados.get('id')
    temperatura = dados.get('temperatura')
    umidade = dados.get('umidade')
    luminosidade = dados.get('luminosidade')
    horario = dados.get('horario')

    # Adicionar os dados à estrutura de dados
    dados_do_sensor.append({
        'id': dado_id,
        'temperatura': temperatura,
        'umidade': umidade,
        'luminosidade': luminosidade,
        'horario': horario
    })

    return jsonify({'mensagem': 'Dados recebidos'})

# Rota para fornecer os dados ao Cliente 2
@app.route('/dados', methods=['GET'])
def get_data():
    if not dados_do_sensor:
        return jsonify({'mensagem': 'Nao a dados'})

    latest_data = dados_do_sensor[-1]

    return jsonify(latest_data)

# Rota para visualizar todos os dados
#Invoke-RestMethod -Uri "http://localhost:5000/dados/todos" -Method Get
@app.route('/dados/todos', methods=['GET'])
def get_all_data():
    return jsonify(dados_do_sensor)

# Rota para visualizar dados por ID
#Invoke-RestMethod -Uri "http://localhost:5000/dados/*id*" -Method Get
@app.route('/dados/<int:dado_id>', methods=['GET'])
def get_data_by_id(dado_id):
    for dado in dados_do_sensor:
        if dado['id'] == dado_id:
            return jsonify(dado)
    return jsonify({'mensagem': 'Nenhum dado encontrado para id ' + str(dado_id)})

# Rota para excluir dados por ID
#Invoke-RestMethod -Uri "http://localhost:5000/dados/*id*" -Method Delete
@app.route('/dados/<int:dado_id>', methods=['DELETE'])
def delete_data(dado_id):
    global dados_do_sensor
    for dado in dados_do_sensor:
        if dado['id'] == dado_id:
            dados_do_sensor.remove(dado)
            return jsonify({'mensagem': 'Dados do id ' + str(dado_id) + ' excluido'})
    return jsonify({'mensagem': 'Nenhum dado encontrado para id ' + str(dado_id)})

# Rota para editar dados por ID  

#$jsonData = @{
#    "id" = 45
#    "temperatura" = 25.5                                       
#    "umidade" = 60
#    "luminosidade" = 500
#    "horario" = "2023-09-28T14:30:00"
#} | ConvertTo-Json
 #Invoke-RestMethod -Uri "http://localhost:5000/dados/*id*" -Method Put -Body $jsonData -ContentType "application/json"

@app.route('/dados/<int:dado_id>', methods=['PUT'])
def edit_data_by_id(dado_id):
    new_data = request.json
    for dado in dados_do_sensor:
        if dado['id'] == dado_id:
            dado.update(new_data)
            return jsonify({'mensagem': 'Dados do id ' + str(dado_id) + ' atualizado'})
    return jsonify({'mensagem': 'Nenhum dado encontrado para id ' + str(dado_id)})

# Rota para obter dados por data e hora específicas
@app.route('/dados/datahora', methods=['GET'])
def get_data_by_datahora():
    datahora = request.args.get('datahora')

    matching_data = []
    for data in dados_do_sensor:
        # Suponha que 'horario' seja uma string no formato "29/Sep/2023 08:22:50"
        if data['horario'] == datahora:
            matching_data.append(data)

    if not matching_data:
        return jsonify({'mensagem': 'Nenhum dado encontrado para a data e hora especificadas'})

    return jsonify(matching_data)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
