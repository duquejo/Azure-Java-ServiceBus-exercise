# Azure ServiceBus Pub/Sub Spring boot exercise
A simple Java Spring boot Pub/Sub monolith using Azure ServiceBus topic message broker. Built with Maven.

## Simple usage
1. Login to Azure CLI using the `az login` command.
2. Run `terraform apply` for IaC planning and creation.
3. Ensure that the base infrastructure is created in your registered Azure DevOps account.
4. Locate the Shared Resources Policies tab from the ServiceBus namespace resource in Azure DevOps and retrieve a valid Connection String.
5. Copy the base environment properties file sample `src/main/resources/application.yml.sample` rename it as `application.yml` and complete the missing properties.
6. Run Spring boot.

## Technologies used
* **Terraform**: AzureRM Provider for better Infrastructure as a code (IaC) handling.
* **Springboot**: Java framework for Microservices integration/RESTController logic.

### Dependencies
* Java (18)
* Spring boot (3.0.6)
* Spring cloud Azure starter servicebus-jms (5.1.0)
* Spring cloud Azure dependencies (5.1.0)
* Google Gson (2.9.1)
* Terraform (13)

### Plugins
* Maven
* Spotless
* Javadoc

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [Terraform Azure Provider](https://registry.terraform.io/providers/hashicorp/azurerm/latest/docs)
