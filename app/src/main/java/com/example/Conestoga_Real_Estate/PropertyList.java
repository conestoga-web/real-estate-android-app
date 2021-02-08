package com.example.Conestoga_Real_Estate;

import java.util.ArrayList;

public class PropertyList {

    private static final PropertyList ourInstance = new PropertyList();

    private ArrayList<Property> mProperty;

    public static PropertyList getInstance() {

        return ourInstance;

    }

    private PropertyList() {

        mProperty = new ArrayList<Property>();

        Property tempProp = new Property("Gorgeous 4 Bedroom Home for Sale in Kitchener",
                "XYZ The Country Road, Kitchener, ON N2E 6T7, Canada",
                "4 Bedroom",
                "Furnished",
                "1,358",
                2,
                "Beautifully renovated all brick 3+1 Bedroom 2 bath , 4 level backsplit home is waiting for you. This home boasts too many upgrades to list within the past 2 years. Carpet free home with newer laminate floors throughout and has been painting a calm grey with dynamic accent colours. There are lots of new large windows throughout including the wall of bay windows in the front living room.",
                "17 July 2019",
                "$624,000.00",
                "@drawable/p1",
                "@drawable/sp1", "Sale");

        mProperty.add(tempProp);

        tempProp = new Property("To Be Built 4 Bedroom Home for Sale in Wellesley",
                "3455, Gerber Meadows Road, Wellesley, ON N0B 958, Canada",
                "4",
                "Furnished",
                "2625",
                2,
                "This home is located in the quaint village of Wellesley. 4 bed, 2 1/2 bath with a welcoming front Foyer leading to an open concept great room with open to above 2 storey ceilings.",
                "14 July 2019",
                "$8,190.00",
                "@drawable/p2",
                "@drawable/sp2", "Rent");

        mProperty.add(tempProp);

        tempProp = new Property("Beautiful Brand New Bungalow Home for Sale in Milverton",
                "West St, Milverton, ON, Canada",
                "2",
                "Not Furnished",
                "1650",
                2,
                "The home boast a stone and brick exterior with double car drive through garage with a door at the back of the garage for easy future yard access. The interior boasts 9 ft ceilings and 8 ft doors for that luxury feel. The great room features vaulted ceilings and gas fireplace. ",
                "07 July 2019",
                "$5,590.00",
                "@drawable/p3",
                "@drawable/sp3", "Rent");

        mProperty.add(tempProp);

        tempProp = new Property("Waterfront Property! 3 Bedroom 2 Bath Bungalow!",
                "South Bruce Peninsula, N0H2T0 ON, Canada",
                "3",
                "Furnished",
                "3650",
                2,
                "Main flr offers stunning water views around grand fireplace with wood insert, LR cathedral ceiling hrdwd flrs, wrap around kitchen with laundry area, enjoy quiet time in the sunroom all yr. Main flr lg master with water view, ensuite newly renovated, 3dbl closets. 2 more bdrms/office.",
                "16 July 2019",
                "$7,999.00",
                "@drawable/p4",
                "@drawable/sp4", "Rent");

        mProperty.add(tempProp);

        tempProp = new Property("AAA Location for this 3 Bedroom Pioneer Park Home",
                "6y36 Vintage Crescent, Kitchener, ON N2P 684, Canada",
                "3",
                "Furnished",
                "1367",
                1,
                "Formal dining room with double sided, woodburning fireplace and cherry hardwood floor, large kitchen with gas stove, ceramic tiling & convenient walkout to the backyard. Professionally finished basement in 2014.\n\nFurnace, a/c and roof in 2011. New kitchen countertops, sink and tap - 2019. Spacious master bedroom with huge closet. Updated bathrooms, including dual flush toilets and whirlpool tub. Some newer windows. Oversized garage with workshop area, separate furnace and double driveway.",
                "15 July 2019",
                "$449,900.00",
                "@drawable/p5",
                "@drawable/sp5", "Sale");

        mProperty.add(tempProp);

//-------------------- added property ------------------------

        tempProp = new Property("2 Bedroom Apartments for Rent ",
                "12 and 15 Overlea Drive, Kitchener, ON, N2M 5C, Canada",
                "2",
                "Not Furnished",
                "1167",
                1,
                "Realstar's Capitol Hill Apartments is ideally located in the Forest Hills at the main intersection of Highland Rd. W. and Westmount Rd. W. These rental apartments feature many renovations and upgrades and are close to all major stores, bus routes and Conestoga Prkwy access.",
                "05 August 2019",
                "$1,575.00",
                "@drawable/p6",
                "@drawable/sp6", "Rent");

        mProperty.add(tempProp);

        tempProp = new Property("Detached Freehold House For Rent – all utilities included",
                "Glen Vista Dr, Hamilton, ON L8K, Canada",
                "3",
                "Not Furnished",
                "1367",
                2,
                "Short drive to Conestoga College, Laurier University, Waterloo University, Blackberry Headquarters, Google Headquarters, Grand River Hospital and very close to other amenities including transportation.\n" +
                        "\n" +
                        "Smoke-free home\n" +
                        "Available to rent September 1st - Rent $2350 including utilities\n" +
                        "\n" +
                        "All interested parties will have to provide the following if selected for yearly lease.\n" +
                        "- Proof of employment\n" +
                        "- Credit Report\n" +
                        "- Last 2 paystubs,\n" +
                        "- First & last months rent payment, as well as 10 post dated cheques",
                "29 July 2019",
                "$2,350.00",
                "@drawable/p7",
                "@drawable/sp7", "Rent");

        mProperty.add(tempProp);

        tempProp = new Property("2 bedroom apartment for rent close to Highway 400 in Barrie",
                "108 Edgehill Drive, Barrie, ON, L4N 5A3, Canada",
                "2",
                "Not Furnished",
                "1470",
                1,
                "Living with Realstar\n" +
                        " Live well with 24 hour on-site management. Realstar strives to provide you with a superior living experience and exceptional resident care. We organize social events that foster a sense of community. Realstar buildings are impeccably clean, well maintained and environmentally efficient.",
                "03 August 2019",
                "$842,567.00",
                "@drawable/p8",
                "@drawable/sp8", "Sale");

        mProperty.add(tempProp);

        tempProp = new Property("Impressive Bungalow in a Lovely Country Setting for Sale! ",
                "Barrie, L4N 9G2, ON, Canada",
                "4",
                "Furnished",
                "1367",
                2,
                "This Immaculately Kept Ranch Bungalow Offers You A Country Setting on a 75’ X 200’ Treed Lot With Driveway Access to the Backyard, Located in South End of Barrie. This Great Family Home has an Impressive Living Room with Gas Fireplace, Crown Mouldings and A Large Bay Window Overlooking the Front Yard. On the Main Floor there are 3 Good Sized Bedrooms Plus a 4 piece bathroom with Jacuzzi Tub, and Vanity with a Marble Countertop. The Spacious Kitchen has Lots of Cabinets, and Counter Space, Pocket Doors and Spacious Eating Area. From the Kitchen you can access the Fully Fenced Gated Private Backyard that Features a 12’ X 26’ Pressure Treated Deck, Great for Entertaining Family and Friends. The lower level is Finished with a Rec Room with Electric Fireplace and Bar, Perfect for Entertaining, 4th bedroom, Second Bathroom (3pc), Laundry Room, Large Storage Room and Access to the Garage.",
                "06 August 2019",
                "$499,879.00",
                "@drawable/p9",
                "@drawable/sp9", "Sale");

        mProperty.add(tempProp);

        tempProp = new Property("AAA Location for this 3 Bedroom Pioneer Park Homes",
                "42 Eder Trail, Minesing, ON, L0L 1Y3, Canada",
                "5",
                "Furnished",
                "3810",
                3,
                "Prestigious Active-Lifestyle Community! Fully Finished 3+2 Bed/3 Bath Bungalow. Heated Double Garage w/Workshop Area. Covered Front Porch. Formal Living & Dining Rm w/Hardwood & Crown Molding. Eat-In Kitchen w/Upsized Ceramics, Newer SS Appliances & Breakfast Bar. Family Rm w/Hardwood & Fireplace. M/F Laundry/Mud Rm. Master w/Newer Ensuite & W/I Closet. Updated Main Bath. Lower Level Offers A Family Rm w/Gas Fireplace, Games Rm, 2 Bedrooms, Full Bath & Cold Cellar. Tons Of Storage & Parking. Private Backyard w/Mature Trees, Shed & Deck. Furnace 2016. Peaceful Setting Just Minutes To Barrie, Hwy 400, Golfing & Ski Hills. Great Opportunity!",
                "12 August 2019",
                "$699,000.00",
                "@drawable/p10",
                "@drawable/sp10", "Sale");

        mProperty.add(tempProp);


    }

    public ArrayList<Property> getProperty(){

        return mProperty;

    }


}
