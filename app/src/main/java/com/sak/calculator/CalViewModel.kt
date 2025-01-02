package com.sak.calculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow



class CalViewModel : ViewModel() {
    private val _state = mutableStateOf(CalculationState())
    val state: State<CalculationState>  = _state

    fun enterdata(number: String) {
        // If the input is "0" or empty, replace it with the entered number
        if (_state.value.inputstate == "0" || _state.value.inputstate.isEmpty()) {
            _state.value = _state.value.copy(inputstate = number)
        } else {
            // Ensure there is a valid character to check
            val lastChar = _state.value.inputstate.lastOrNull()?.toString() ?: ""

            // Append the new number to the existing input state
            _state.value = _state.value.copy(inputstate = _state.value.inputstate + number)
        }
    }

    fun cleardata(){
        _state.value=_state.value.copy(inputstate = "0")
    }
    fun deletedata(){
        var temp:String=_state.value.inputstate.dropLast(1)
        if(_state.value.inputstate=="0"){
            _state.value=_state.value.copy(inputstate = "0")

        }
        else{
        _state.value=_state.value.copy(inputstate=temp )
    }}
    fun calculate() {
        val temp = _state.value.inputstate
        val numbers = mutableListOf<Double>() // List to store numbers
        val operators = mutableListOf<Char>() // List to store operators

        var currentNumber = ""

        // Separate numbers and operators
        for (char in temp) {
            if (char.isDigit() || char == '.') {
                currentNumber += char // Build the current number
            } else if (char == '%' || char == '+' || char == '-' || char == 'x' || char == '÷') {
                if (currentNumber.isNotEmpty()) {
                    numbers.add(currentNumber.toDouble()) // Add the completed number
                    currentNumber = "" // Reset for the next number
                }
                operators.add(char) // Add the operator
            }
        }

        // Add the last number if any
        if (currentNumber.isNotEmpty()) {
            numbers.add(currentNumber.toDouble())
        }

        // Perform the calculation
        var result = numbers[0]
        for (i in operators.indices) {
            val nextNumber = numbers[i + 1]
            result = when (operators[i]) {
                '+' -> result + nextNumber
                '-' -> result - nextNumber
                'x' -> result * nextNumber
                '÷' -> {
                    if (nextNumber == 0.0) {
                        _state.value = _state.value.copy(inputstate = "Error") // Handle division by zero
                        return
                    }
                    result / nextNumber
                }
                '%' -> result % nextNumber
                else -> result
            }
        }

        // Update the state with the result
        _state.value = _state.value.copy(inputstate = result.toString())
    }
}
