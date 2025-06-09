package example.jemin.demo.modules.place.domain

data class Place(val id: Long?, val name: String, val address: Address) {

    data class Address(val region: Region, val fullName: String, val building: Building) {
        data class Region(
            val depthFirst: String,
            val depthSecond: String,
            val depthThird: String,
            val roadName: String,
            val coordinate: Coordinate,
        ) {
            data class Coordinate(val xAxis: Double, val yAxis: Double)
        }

        data class Building(
            val mainBuildingNumber: Int,
            val subBuildingNumber: Int,
            val isUnderground: Boolean,
            val name: String,
        )
    }
}
