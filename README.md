# 3Att
rm -rf ./allure-results
mvn $1 clean test
cp -r ./allure-report/history ./allure-results/history
rm -rf ./allure-report

allure generate
allure open
