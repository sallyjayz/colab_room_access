package com.sallyjayz.colabsroomaccess.ui.explore.carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.sallyjayz.colabsroomaccess.ui.explore.CarouselItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

/**
 * Created by Salama Jatau on 23-Mar-26.
 */

@Composable
fun HeroCarousel(items: List<CarouselItem>) {
    val pageCount = items.size
    val pagerState = rememberPagerState(pageCount = { pageCount })
    val autoScrollDuration = 3000L

    Box(modifier = Modifier.fillMaxWidth().height(250.dp)) {

        val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
        if (isDragged.not()) {
            with(pagerState) {
                var currentPageKey by remember { mutableStateOf(0) }
                LaunchedEffect(key1 = currentPageKey) {
                    launch {
                        delay(timeMillis = autoScrollDuration)
                        val nextPage = (currentPage + 1).mod(pageCount)
                        animateScrollToPage(page = nextPage)
                        currentPageKey = nextPage
                    }
                }
            }
        }

        // 1. The Carousel
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSpacing = 0.dp, // Ensures no next-item peek
        ) { page ->
            // Replace with your actual item composable (e.g., Image)
            Box(
                Modifier.fillMaxSize().background(Color.Gray).carouselTransition(page, pagerState),
                contentAlignment = Alignment.Center
            ) {
//                 Text(text = "Page $page")

                val item = items[page]
                Image(
                    modifier = Modifier.fillMaxWidth()
//                        .height(205.dp)
////                        .maskClip(MaterialTheme.shapes.extraLarge)
                    ,
                    painter = painterResource(id = item.imageResId),
                    contentDescription = item.contentDescription,
                    contentScale = ContentScale.Crop
                )
            }
        }

        // 2. The Indicator at the Top
        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter) // Position at top
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pageCount) { iteration ->

                /*val isSelected = pagerState.currentPage == iteration

                // Customize width and color based on selection
                val width = if (isSelected) 24.dp else 12.dp
                val color = if (isSelected) Color.DarkGray else Color.LightGray.copy(alpha = 0.5f)

                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(4.dp)) // Rounded corners for dash
                        .background(color)
                        .size(width = width, height = 5.dp) // Long, thin shape
                )*/

//                val width = (LocalConfiguration.current.screenWidthDp / pageCount) - (LocalConfiguration.current.screenWidthDp - 32)
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(4.dp)
//                        .clip(CircleShape)
                        .clip(RoundedCornerShape(4.dp))
                        .background(color)
                        .size(width = 50.dp, height = 5.dp)
                )
            }
        }
    }
}

fun Modifier.carouselTransition(page: Int, pagerState: PagerState) =
    graphicsLayer {
        val pageOffset =
            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

        val transformation =
            lerp(
                start = 0.7f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f)
            )
        alpha = transformation
        scaleY = transformation
    }