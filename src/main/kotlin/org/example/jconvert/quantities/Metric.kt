package org.example.jconvert.quantities

enum class Metric(val v: Double) {
    yotta(1.0E24),
    zetta(1.0E21),
    exa(1.0E18),
    peta(1.0E15),
    tera(1.0E12),
    giga(1.0E9),
    mega(1000000.0),
    kilo(1000.0),
    hecto(100.0),
    deca(10.0),
    zero(1.0),
    deci(0.1),
    centi(0.01),
    milli(0.001),
    micro(1.0E-6),
    nano(1.0E-9),
    pico(1.0E-12),
    femto(1.0E-15),
    atto(1.0E-18),
    zepto(1.0E-21),
    yocto(1.0E-24)

}
