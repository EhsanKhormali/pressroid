package ir.shchooltech.pressroid.models

sealed class ProductType<T> {
    data class Simple<T>(val data:T):ProductType<T>()
    data class Grouped<T>(val data:T):ProductType<T>()
    data class External<T>(val data:T):ProductType<T>()
    data class Variable<T>(val data:T):ProductType<T>()
}