package com.example.baseproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseproject.repository.MatchesRepository
import com.example.baseproject.viewmodel.state.MatchesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(private val matchesRepository: MatchesRepository): ViewModel() {

    private var _matchesState = MutableStateFlow<MatchesState>(MatchesState.Empty)
    private var matchesState: StateFlow<MatchesState> = _matchesState

    init {
        getAllMatches()
    }

    private fun getAllMatches() {
        _matchesState.value = MatchesState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val matchesResponse = matchesRepository.getAllMatches()
                _matchesState.value = MatchesState.Success(matchesResponse)
            }
            catch (exception: HttpException) {
                _matchesState.value = MatchesState.Error("No internet connection")
            }
            catch (exception: IOException) {
                _matchesState.value = MatchesState.Error("Something went wrong")
            }
        }
    }
}