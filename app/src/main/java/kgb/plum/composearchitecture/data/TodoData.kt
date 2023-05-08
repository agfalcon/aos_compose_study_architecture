package kgb.plum.composearchitecture.data

data class TodoData(
    val id : Int,
    val content : String,
    val done : Boolean = false,
)
