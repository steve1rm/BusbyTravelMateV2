package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
        FlowRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)) {

            Text(modifier = Modifier
                .background(color = Color.Blue)
                .padding(horizontal = 8.dp)
                .defaultMinSize(minWidth = maxWidthDp)
                .onSizeChanged { size ->
                    maxWidth = max(maxWidth, size.width)
                },
                text = "Top Value", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .background(color = Color.Blue)
                    .padding(horizontal = 8.dp)
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Highly Rated", fontSize = 12.sp)
        }

        HotelDetailHeader()

        FlowRow(modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)) {

            Text(modifier = Modifier
                .background(color = Color.Green)
                .padding(horizontal = 8.dp)
                .defaultMinSize(minWidth = maxWidthDp)
                .onSizeChanged { size ->
                    maxWidth = max(maxWidth, size.width)
                },
                text = "Breakfast", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .background(color = Color.Green)
                    .padding(horizontal = 8.dp)
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Parking", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .background(color = Color.Green)
                    .padding(horizontal = 8.dp)
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Free Wifi", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .background(color = Color.Green)
                    .padding(horizontal = 8.dp)
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Cancellation", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .background(color = Color.Green)
                    .padding(horizontal = 8.dp)
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Preferred", fontSize = 12.sp)

            Text(modifier = Modifier
                .background(color = Color.Green)
                .padding(horizontal = 8.dp)
                .defaultMinSize(minWidth = maxWidthDp)
                .onSizeChanged { size ->
                    maxWidth = max(maxWidth, size.width)
                },
                text = "Exclusive", fontSize = 12.sp)

            Text(
                modifier = Modifier
                    .background(color = Color.Green)
                    .padding(horizontal = 8.dp)
                    .defaultMinSize(minWidth = maxWidthDp)
                    .onSizeChanged { size ->
                        maxWidth = max(maxWidth, size.width)
                    },
                text = "Discounts", fontSize = 12.sp)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                tint = Color.LightGray
            )

            Text(
                text = "Cashback rewards",
                fontSize = 12.sp
            )

            Text(
                text = "B 275.59 (Terms apply)",
                fontSize = 12.sp
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                text = "B 1,781",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = null,
                tint = Color.LightGray
            )

            Text(
                text = "AGODASPONSORED - B 171 off!",
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun HotelDetailHeader() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Lloyd's Inn Bali"
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(4) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                }

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color.LightGray
                )

                Text(
                    text = "Seminyak - City Center"
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = {},
                content = {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share this hotel"
                    )
                }
            )

            IconButton(
                onClick = {},
                content = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Share this hotel"
                    )
                }
            )
        }
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "8.6 Excellent",
            color = Color.Blue
        )

        Text(
            text = "2,305 reviews",
            color = Color.LightGray
        )
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
    //    HotelImageCard()
        HotelDetailCard()
    }
}