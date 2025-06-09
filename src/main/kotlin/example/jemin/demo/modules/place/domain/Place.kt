package example.jemin.demo.modules.place.domain

data class Place(val id: Long?, val name: String, val address: Address) {
    data class Address(val region: Region, val fullName: String, val building: Building) {
        data class Region(val depth: Depth, val roadName: String, val coordinate: Coordinate) {
            data class Coordinate(val xAxis: Double, val yAxis: Double)

            data class Depth(val first: String, val second: String, val third: String)
        }

        data class Building(
            val mainBuildingNumber: Int,
            val subBuildingNumber: Int,
            val isUnderground: Boolean,
            val name: String,
        )
    }
}
