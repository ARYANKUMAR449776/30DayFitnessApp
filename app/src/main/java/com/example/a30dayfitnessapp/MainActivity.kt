package com.example.a30dayfitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30dayfitnessapp.data.Exercise
import com.example.a30dayfitnessapp.data.exercises
import com.example.a30dayfitnessapp.ui.theme._30DayFitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DayFitnessAppTheme {
                FitnessApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        CenterAlignedTopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_fitness_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.padding_large))
                            .padding(dimensionResource(R.dimen.padding_small))
                    )
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            }
        )
    }
}

@Composable
fun FitnessApp() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        FitnessTopAppBar()
    }) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(exercises) { exercise ->
                ExerciseItem(exercise = exercise, Modifier.padding(dimensionResource(R.dimen.padding_small)))
            }
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    )

    // Make the whole Card clickable
    Card(
        modifier = modifier.clickable { expanded = !expanded } // Make Card clickable
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            ).background(color = color)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                ExerciseIcon(exercise.imageResourceId)
                ExerciseInformation(exercise.day,exercise.name, exercise.duration)
            }
            if (expanded) {
                ExerciseDescription(exercise.description, modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_small),
                    end = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_medium)
                ))
            }
        }
    }
}


@Composable
fun ExerciseDescription(
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Description:",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.surfaceDim
        )
        Text(
            text = stringResource(description),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.surfaceDim
        )
    }
}

@Composable
fun ExerciseIcon(@DrawableRes exerciseIcon: Int) {
    Image(
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(exerciseIcon),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun ExerciseInformation(
    exerciseDay:Int,
    @StringRes exerciseName: Int,
    exerciseDuration: Int
) {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 5.dp)) {
        Text(
            text = ("Day "+ exerciseDay.toString()),
            style = MaterialTheme.typography.headlineSmall ,
            color = MaterialTheme.colorScheme.surfaceDim,
            fontWeight = FontWeight.ExtraBold

        )
        Text(
            text = ("Exercise: "+stringResource(exerciseName)),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.surfaceDim
        )
        Text(
            text = ("Duration: "+(exerciseDuration).toString() +" Minutes") ,
            style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.surfaceDim
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DayFitnessAppTheme {
        FitnessApp()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewDark() {
    _30DayFitnessAppTheme(darkTheme = true) {
        FitnessApp()
    }
}
