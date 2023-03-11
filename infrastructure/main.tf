resource "azurerm_resource_group" "rg" {
  location = "switzerlandnorth"
  name     = "hamsterwheel"
}

resource "azurerm_servicebus_namespace" "namespace" {
  location            = "switzerlandnorth"
  name                = "sunflowers"
  resource_group_name = "hamsterwheel"
  sku                 = "Standard"
}

resource "azurerm_servicebus_queue" "cheeks" {
  name         = "cheeks"
  namespace_id = azurerm_servicebus_namespace.namespace.id
}

resource "azurerm_servicebus_queue" "seeds" {
  name         = "cheeks"
  namespace_id = azurerm_servicebus_namespace.namespace.id
}
