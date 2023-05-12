variable "resource_group" {
  description = "Resource Group for the Azure ServiceBus"
  type        = string
  default     = "servicebus_group"
}

variable "pricing_tier" {
  description = "Azure ServiceBus Topic pricing tier"
  type        = string
  default     = "Standard"
}