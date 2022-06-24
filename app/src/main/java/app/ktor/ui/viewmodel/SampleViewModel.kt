package app.ktor.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ktor.ui.model.Sample
import app.ktor.ui.repository.SampleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SampleViewModel : ViewModel() {

    val sampleDetailFlow = MutableStateFlow<Sample?>(null)

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                SampleRepository.getSimpleDetail()
            }.onSuccess {
                sampleDetailFlow.value = it
            }.onFailure {
                sampleDetailFlow.value = null
            }
        }
    }


}