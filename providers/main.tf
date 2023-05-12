terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=3.0.0"
    }
  }
}

# Configure the Microsoft Azure Provider
provider "azurerm" {
  features {}
}

# Resource group
resource "azurerm_resource_group" "servicebus_group" {
  name     = var.resource_group
  location = "East US"
}

# Queue config
# 1. Creates the service bus namespace
resource "azurerm_servicebus_namespace" "servicebus_namespace" {
  name                = "tfex-servicebus-temp-namespace"
  location            = azurerm_resource_group.servicebus_group.location
  resource_group_name = azurerm_resource_group.servicebus_group.name
  sku                 = var.pricing_tier

  tags = local.common_tags
}

# 2. Creates a sample topic
resource "azurerm_servicebus_topic" "servicebus_users_topic" {
  name         = "tfex-servicebus-temp-users-topic"
  namespace_id = azurerm_servicebus_namespace.servicebus_namespace.id
}

# 3. Creates a subscription based on topic.
resource "azurerm_servicebus_subscription" "servicebus_users_sub" {
  name               = "tfex-servicebus-temp-users-sub"
  topic_id           = azurerm_servicebus_topic.servicebus_users_topic.id
  max_delivery_count = 3
}

# 4. Define a Shared Access Policies for the Service Bus Topic
resource "azurerm_servicebus_namespace_authorization_rule" "servicebus_users_send_rule" {
  name         = "tfex-servicebus-temp-send"
  namespace_id = azurerm_servicebus_namespace.servicebus_namespace.id

  listen = false
  send   = true
  manage = false
}

resource "azurerm_servicebus_namespace_authorization_rule" "servicebus_users_listen_rule" {
  name         = "tfex-servicebus-temp-listen"
  namespace_id = azurerm_servicebus_namespace.servicebus_namespace.id

  listen = true
  send   = false
  manage = false
}