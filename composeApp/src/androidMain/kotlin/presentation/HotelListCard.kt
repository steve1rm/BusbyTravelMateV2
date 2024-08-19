package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.busbytravelmatev2.R
import presentation.designsystem.ui.theme.BusbyTravelMateTheme
import kotlin.math.max

@Composable
fun HotelListCard(
    modifier: Modifier = Modifier
) {

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HotelDetailCard(
    modifier: Modifier = Modifier
) {
    var maxWidth by remember {
        mutableIntStateOf(0)
    }

    val maxWidthDp = with(LocalDensity.current) {
        maxWidth.toDp()
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        FlowRow(modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)) {

            Text(modifier = Modifier
                .defaultMinSize(minWidth = maxWidthDp)
                .onSizeChanged { size ->
                    maxWidth = max(maxWidth, size.width)
                },
                text = "Breakfast Included", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Free Cancellation", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Preferred Room", fontSize = 12.sp)
            Text(modifier = Modifier
                .defaultMinSize(minWidth = maxWidthDp)
                .onSizeChanged { size ->
                    maxWidth = max(maxWidth, size.width)
                },
                text = "Exclusive Offers", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Discounts Demand", fontSize = 12.sp)
        }
    }
}

@Composable
fun HotelImageCard(
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxWidth().padding(bottom = 44.dp)) {
        Box(
            modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.hotelimage2),
                contentDescription = null
            )

            Text(
                modifier = Modifier.align(Alignment.TopCenter).background(color = Color.Blue)
                    .fillMaxWidth(),
                color = Color.White,
                textAlign = TextAlign.Center,
                text = "Top 11 Gourmet/Cuisine hotels in Bali"
            )

            Text(
                modifier = Modifier.align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 16.dp),
                color = Color.White,
                text = "1/5"
            )
        }

        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(y = 26.dp),
            color = Color.Gray,
            fontSize = 10.sp,
            text = "Sponsored"
        )

        Card(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(y = 20.dp)
                .padding(end = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, end = 16.dp, bottom = 4.dp, start = 16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    color = Color.Red,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    text = "$ 61,569"
                )

                Text(
                    color = Color.Gray,
                    fontSize = 10.sp,
                    text = "1 night with taxes"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageCard() {
    BusbyTravelMateTheme {
        HotelImageCard()
      //  HotelDetailCard()
    }
}