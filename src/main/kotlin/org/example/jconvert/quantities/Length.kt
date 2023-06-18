package org.example.jconvert.quantities

enum class Length(val v: Double) {
    meter(1.0),
    angstrom(1.0e-10),
    mile(1.6 * 1000),
    furlong(200.0),
    chain(20.0),
    rod(5.0),
    pole(5.0),
    perch(5.0),
    fathom(1.8),
    yard(0.91),
    foot(0.3048),
    hand(10.0 / 100),
    inch(25.4 / 1000),
    nautical_mile(1.9 * 1000),
    light_year(9.416E15),
    parsec(3.3 * 9.416e+15)

}
