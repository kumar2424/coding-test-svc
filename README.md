# coding-test-svc

Project

This Microservice performs order processing for a large company

API

1. PUT Request: API to generate physical product
curl -X PUT -d productType="physical product" http://localhost:8080/api/v1/businessrules/payment

2. PUT Request: API to initiate packing slip for book product
curl -X PUT -d productType=book http://localhost:8080/api/v1/businessrules/payment

3. PUT Request: API to Activate membership
curl -X PUT -d productType="membership" http://localhost:8080/api/v1/businessrules/payment

4. PUT Request: API to Upgrade membership
curl -X PUT -d productType="upgrade membership" http://localhost:8080/api/v1/businessrules/payment
