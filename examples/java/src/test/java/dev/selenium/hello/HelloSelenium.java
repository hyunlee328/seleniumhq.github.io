file = 'D:\School\dominoes\StudentSolver.java'
startTime = datetime.datetime.now()
chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument('--user-agent="Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36"')
chrome_options.add_argument('--disable-logging')    
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--start-maximized')
# chrome_options.add_argument('--start-maximized')
# chrome_options.add_argument('--single-process')
chrome_options.add_argument('--disable-dev-shm-usage')
chrome_options.add_argument('--disable-blink-features=AutomationControlled')
chrome_options.add_experimental_option('useAutomationExtension', False)
chrome_options.add_experimental_option("excludeSwitches", ["enable-automation"])
chrome_options.add_argument("disable-infobars")
driver = webdriver.Chrome(chrome_options=chrome_options,service_log_path='NUL')
     
score = 0
attempts = 0
error = 0
highest = 0
while score < 9:
    attempts += 1
    try:
        parent_elem = driver.find_element_by_xpath('//*[@data-row-key="Shang-Chi (Java)"]')
        child_elements = parent_elem.find_elements_by_xpath('.//*[@class="ant-btn ant-btn-primary"]')[0].click()
        time.sleep(6)
        p2 = driver.find_element_by_xpath('//*[@class="ant-modal-body"]')
        c2 = p2.find_elements_by_xpath('.//*[@type="file"]')[0].send_keys(file)
        time.sleep(7)
        p2 = driver.find_element_by_xpath('//*[@class="ant-modal-footer"]')
        c2 = p2.find_elements_by_xpath('.//*[@class="ant-btn ant-btn-primary"]')[0].click()
        time.sleep(5)
        p2 = driver.find_element_by_xpath('//*[@class="ant-modal-body"]')
        c3 = p2.find_elements_by_xpath('.//*[@class="ant-btn ant-btn-primary"]')[0].click()
        c4 = driver.find_elements_by_xpath("//*[text()='Passed']")
        p3 = c4[0].find_element_by_xpath('..').find_element_by_xpath('..')
        c5 = p3.find_elements_by_xpath('.//*[@class="ant-statistic-content-value-int"]')[0]
        score = int(c5.text)
        if score > highest:
            highest = score
        print("attempt: ",attempts,"score: ",c5.text, "highest: ",highest)
        driver.get(url)
        time.sleep(5)
    except:
        error +=1
        print("error: ",error)
        driver.get(url)
        time.sleep(5)
endTime = datetime.datetime.now()
diff = (startTime-endTime).total_seconds() 
print("errors: ",error)
print("10/10 after ",attempts," attempts and after " ,divmod(diff, 60)[0]  ," minutes")
