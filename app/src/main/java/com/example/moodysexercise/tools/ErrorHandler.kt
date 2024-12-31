package com.example.moodysexercise.tools

//More Time: Complete Error Handling
class ErrorHandler {
    companion object {
        fun handleError(error: Throwable) {
            LogHandling.error("An error occurred: ${error.message}")
            // Log the error for debugging purposes
            error.printStackTrace()
        }

        fun handleError(errorMessage: String) {
            LogHandling.error(errorMessage)
        }
    }
}
