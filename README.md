# airline_selenium
airline_selenium

run as maven - test

the below code is failing needed to test it giving stale element exception .

but able to pull all the labels.

for (WebElement subLabel : subItemLabels) {
            navigationLabels.add(subLabel.getText());
            subLabel.click();
            driver.navigate().back();
            Thread.sleep(2000);

        }
        
        for (WebElement subRootLabel : subRootItemLabels) {
            navigationLabels.add(subRootLabel.getText());
            subRootLabel.click();
            driver.navigate().back();
            Thread.sleep(2000);
        }
