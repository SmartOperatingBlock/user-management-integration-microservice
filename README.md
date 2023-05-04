# User Management Integration Microservice

![Build-and-Deploy](https://github.com/smartoperatingblock/user-management-integration-microservice/actions/workflows/build-and-deploy.yml/badge.svg?style=plastic)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=plastic)](https://opensource.org/licenses/MIT)
![Version](https://img.shields.io/github/v/release/smartoperatingblock/user-management-integration-microservice?style=plastic)

[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=SmartOperatingBlock_user-management-integration-microservice&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=SmartOperatingBlock_user-management-integration-microservice)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=SmartOperatingBlock_user-management-integration-microservice&metric=bugs)](https://sonarcloud.io/summary/new_code?id=SmartOperatingBlock_user-management-integration-microservice)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=SmartOperatingBlock_user-management-integration-microservice&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=SmartOperatingBlock_user-management-integration-microservice)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=SmartOperatingBlock_user-management-integration-microservice&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=SmartOperatingBlock_user-management-integration-microservice)

An integration microservice responsible to manage Operating Block users:
- User Authentication
- Health Professionals Digital Twins creation
- Health Professionals information system

## Usage 
1. Provide a `.env` file with the following variables:
    - USER_MANAGEMENT_MONGODB_URL
    - AZURE_CLIENT_ID: ID of an Azure AD application
    - AZURE_TENANT_ID: ID of the application's Azure AD tenant
    - AZURE_CLIENT_SECRET: the application's client secrets
    - AZURE_DT_ENDPOINT: the Azure Digital Twins instance endpoint
2. Run the container with the command:
   
   `docker run ghcr.io/smartoperatingblock/user-management-integration-microservice:latest`

## Documentation
- Check out the *Rest API* [here](https://smartoperatingblock.github.io/user-management-integration-microservice/documentation/openapi-doc)
- Check out the *Code documentation* [here](https://smartoperatingblock.github.io/user-management-integration-microservice/documentation/code-doc)
