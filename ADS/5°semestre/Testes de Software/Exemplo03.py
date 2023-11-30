#Baixar o webdriver https://chromedriver.chromium.org/downloads
#pip install selenium
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
import time

options = webdriver.ChromeOptions()
options.add_argument("--window-size=1980,1020")
options.add_argument("--log-level=3")
#options.add_argument("--headless")
driver = webdriver.Chrome(options=options)
login_url = 'https://kabum.com.br/'

print('Passo 1: Acessar o site da kabum')
try:
    driver.get(login_url)
    driver.implicitly_wait(10)
    driver.save_screenshot('tela01.png')
    time.sleep(2)
except:
    driver.quit()
    print('Erro ao acessar o site da kabum')
    quit()

print('Passo 2: Acessa o menu Departamentos/Computadores/Notebooks/Dell')

try:
    action = ActionChains(driver)
    #Simular o mouse passando no menu Departamentos
    menu = WebDriverWait(driver,20).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="__next"]/header/div[2]/div/nav/div[1]')))
    action.move_to_element(menu).perform()

     #Simular o mouse passando no menu Computadores
    menu = WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.PARTIAL_LINK_TEXT,'Computadores')))
    action.move_to_element(menu).perform()

    #Simular o mouse passando no menu Notebooks
    menu = WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.PARTIAL_LINK_TEXT,'Notebooks')))
    action.move_to_element(menu).perform()

    #Simular o clique no menu Notebooks Dell
    menu = WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.PARTIAL_LINK_TEXT,'Notebook Dell'))).click()

    driver.save_screenshot('tela02.png')
    time.sleep(2)
except:
    driver.quit()
    print('Erro ao acessar o menu...')
    quit()

print('Passo 3: ordenar por preço crescente')
try:
    WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="Filter"]/div[1]/select/option[2]'))).click()
    time.sleep(3)
    driver.save_screenshot('tela03.png')
except:
    driver.quit()
    print('Erro ao ordendar por preço crescente')
    quit()

print('Passo 4: capturar a lista de produtos')
try:
    tabela = WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.XPATH,'//*[@id="listing"]/div[3]/div/div[2]/div/main')))
    conteudo_html = tabela.get_attribute('outerHTML')

    with open('lista_produtos.html', 'w') as arquivo:
        arquivo.write(str(conteudo_html))
    arquivo.close()

except:
    driver.quit()
    print('Erro ao salvar lista de produtos')
    quit()


