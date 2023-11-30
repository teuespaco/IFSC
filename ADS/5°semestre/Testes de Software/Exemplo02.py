#Baixar o webdriver https://chromedriver.chromium.org/downloads
#pip install selenium
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains

options = webdriver.ChromeOptions()
options.add_argument("--window-size=1980,1020")
options.add_argument("--log-level=3")
#options.add_argument("--headless")
driver = webdriver.Chrome(options=options)
login_url = 'https://pmc.sc.gov.br/'

driver.get(login_url)
driver.implicitly_wait(10)


print('Passo 1: Fecha pop-up')

try:
    #Clica na janela de pop-up do IPTU
    WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="popmake-99786"]/button'))).click()
except:
    driver.quit()
    print('Erro ao acessar o menu de ex-prefeitos')
    quit()


print('Passo 2: Acessa o menu de ex-prefeitos')
try:

    #Simular o mouse passando no menu Município
    action = ActionChains(driver)
    menu = driver.find_element(By.ID,"menu-item-2558")
    action.move_to_element(menu).perform()
    #Simular o click em ex-prefeitos
    WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.ID,'menu-item-93281'))).click()
    
except:
    driver.quit()
    print('Erro ao acessar o menu de ex-prefeitos')
    quit()



print('Passo 3: Busca a tabela de ex-prefeitos')
try:
    elemento = driver.find_element(By.XPATH,'//*[@id="post-19376"]/div[1]/table')
    conteudo_html = elemento.get_attribute('outerHTML')
    soup = BeautifulSoup(conteudo_html, 'html.parser')
    tabela = soup.find(name='table')
    print(tabela)
    #Salva como html
    with open('lista.html', 'w') as arquivo:
        arquivo.write(str(tabela))
    arquivo.close()
    
    ''' 
    #Salva como csv
    try:
        with open('lista.csv', 'w') as arquivo:
            for row in soup.find_all('tr'):
                line = ''
                for col in row.find_all('td'):
                    line = line + col.text.lstrip("\n").rstrip("\n") +';'
                arquivo.write(line+'\n')
        arquivo.close
    except:
        print('Erro ao salvar arquivo csv')
    '''
except:
    driver.quit()
    print('Erro ao acessar a tabela de ex-prefeitos')
    quit()

driver.quit()
print('Teste realizado com sucesso!')
