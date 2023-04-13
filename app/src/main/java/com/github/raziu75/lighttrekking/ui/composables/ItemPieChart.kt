package com.github.raziu75.lighttrekking.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.github.raziu75.lighttrekking.model.CategoryItem

@Composable
fun ItemPieChart(
    modifier: Modifier = Modifier,
    categoryTotalWeight: Map<CategoryItem, Double>,
) {
    val categoryColors = mapOf(
        CategoryItem.CLOTHE to Color(0xFF6200EE),
        CategoryItem.ACCESSORY to Color(0xFFBB86FC),
        CategoryItem.FOOD to Color(0xFF03DAC5),
        CategoryItem.OTHER to Color(0xFF3700B3),
    )

    val totalWeight = categoryTotalWeight.values.sum()

    Canvas(modifier = modifier.fillMaxSize()) {
        val radius = size.minDimension / 2
        val strokeWidth = radius / 2
        val innerRadius = radius / 2
        var startAngle = 0f

        for ((category, weight) in categoryTotalWeight) {
            val sweepAngle = ((weight / totalWeight) * 360).toFloat()
            drawArc(
                color = categoryColors[category] ?: Color.Black,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = Offset(
                    (size.width / 2) - radius,
                    (size.height / 2) - radius
                ),
                size = size.copy(width = radius * 2, height = radius * 2),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
            startAngle += sweepAngle
        }

        drawCircle(
            color = Color.White,
            center = Offset(size.width / 2, size.height / 2),
            radius = innerRadius
        )
    }
}
