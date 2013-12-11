package com.adam.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-11T13:48:15")
@StaticMetamodel(Pembelian.class)
public class Pembelian_ { 

    public static volatile SingularAttribute<Pembelian, Integer> idPbl;
    public static volatile SingularAttribute<Pembelian, Date> tglTrskPbl;
    public static volatile SingularAttribute<Pembelian, Float> satuanTrskPbl;
    public static volatile SingularAttribute<Pembelian, Integer> qtyTrskPbl;
    public static volatile SingularAttribute<Pembelian, Float> subtotalTrskPbl;

}