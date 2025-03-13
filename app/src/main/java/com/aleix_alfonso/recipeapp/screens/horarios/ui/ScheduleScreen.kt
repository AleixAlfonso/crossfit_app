package com.aleix_alfonso.recipeapp.screens.horarios.ui

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleix_alfonso.recipeapp.data.models.ClassDomainModel
import com.aleix_alfonso.recipeapp.screens.horarios.HorariosViewModel
import com.aleix_alfonso.recipeapp.screens.horarios.HorariosViewState
import com.aleix_alfonso.recipeapp.ui.components.CrossfitAppScreenContainer
import com.aleix_alfonso.recipeapp.ui.components.TopBarCustom

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ScheduleScreen(
    viewModel: HorariosViewModel,
    onArrowBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedDay by remember { mutableStateOf("V") }
    val viewState = viewModel.state.collectAsState()
    CrossfitAppScreenContainer(
        topBar = {
            TopBarCustom(
                title = "Horarios",
                arrowBackEnabled = true,
                onArrowBackClick = onArrowBackClick
            )
        },
        scrollEnabled = false,
        content = {
            DaysRow({ selectedDay = it }, selectedDay)
            when (val state = viewState.value) {
                is HorariosViewState.Initial -> {
                    viewModel.getHorarios()
                }

                is HorariosViewState.Loading -> {

                }

                is HorariosViewState.Active -> {
                    Log.i("ScheduleScreenData", state.horariosDomainModel.classList.toString())
                    ClassList(
                        selectedDay = selectedDay,
                        classes = state.horariosDomainModel.classList
                    )
                }
            }
        }
    )
}

@Composable
fun DaysRow(onDayClick: (String) -> Unit, selectedDay: String, modifier: Modifier = Modifier) {
    val days = listOf("L", "M", "X", "J", "V", "S", "D")
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            days.forEach { day ->
                DayButton(
                    text = day,
                    isSelected = day == selectedDay,
                    onClick = { onDayClick(day) }
                )
            }
        }
    }

}

@Composable
fun DayButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = if (isSelected) Color(0xFF1E88E5) else Color.Transparent,
            border = if (!isSelected) ButtonDefaults.outlinedButtonBorder else null
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClassList(selectedDay: String, classes: List<ClassDomainModel>, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(classes.filter { classItem -> classItem.days.contains(selectedDay) }
                .sortedBy {
                    val timeParts = it.start.split(":")
                    val hours = timeParts[0].toInt()
                    val minutes = timeParts[1].toInt()
                    hours * 60 + minutes
                }) { classItem ->
                ClassCard(classItem)
            }
        }

    }

}


@Composable
fun ClassCard(classItem: ClassDomainModel, modifier: Modifier = Modifier) {

    OutlinedCard(
        onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
    ) {

        Row(modifier = Modifier.fillMaxHeight()) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = classItem.start)
                Text(text = classItem.end)
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(
                        color = when (classItem.subType) {
                            "LLIURE - OPOS" -> Color(0xFF105133)
                            "CROSSFIT" -> Color(0xFFFC5856)
                            "PERFORMANCE" -> Color(0xFFD1E6DD)
                            "OPEN BOX ENTRADA" -> Color(0xFFD93F0B)
                            "OPEN BOX SALA ESCART" -> Color(0xFF0E8B16)
                            else -> Color.Black
                        }
                    )
                    .width(7.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = classItem.type)
                Text(text = classItem.subType)
            }
        }
    }
}

