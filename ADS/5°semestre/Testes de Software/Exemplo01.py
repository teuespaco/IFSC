#Baixar o webdriver https://chromedriver.chromium.org/downloads
#pip install selenium
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
login_url = 'https://sig.ifsc.edu.br/sigaa/public/home.jsf'

driver.get(login_url)
driver.implicitly_wait(10)

print('Passo 1: Clica no link de acesso ao login')
try:
    driver.find_element(By.XPATH,'//*[@id="acesso"]/ul/li[2]/a').click()

except:
    driver.quit()
    print('Erro ao localizar link de acesso à tela de login')

print('Passo 2: Envia os dados para o login')
username = 'coloque seu usuário aqui'
password = 'Coloque sua senha aqui'
try:
        driver.find_element(By.XPATH,'//*[@id="loginForm"]/table/tbody/tr[1]/td/input').send_keys(username)
        driver.find_element(By.XPATH,'//*[@id="loginForm"]/table/tbody/tr[2]/td/input').send_keys(password, Keys.ENTER)
except:
        driver.quit()
        print('Erro ao enviar dados para o login')


print('Passo 3: Clica no link sair')
try:
    driver.find_element(By.XPATH,'//*[@id="info-sistema"]/div/span[3]/a').click()
except:
    driver.quit()
    print('Erro ao localizar link sair')


driver.quit()
print('Teste realizado com sucesso!')
