package org.example.jconvert.quantities

enum class Force(val v: Double) {
    newton(1.0),
    dyne(1e+5),
    pond(0.00980665),
    tonne_force(9806.65),
    kilogram_force(9.80665),
    poundal(0.138255),
    long_ton_force(10000.0),
    short_ton_force(8.9 * 1000),
    pound_force(4.4),
    ounce_force(280.0 / 1000),
    gram_force(9.8 / 1000),
    grain_force(640.0 / 1000000)

}
