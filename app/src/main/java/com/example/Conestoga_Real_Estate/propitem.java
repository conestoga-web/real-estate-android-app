package com.example.Conestoga_Real_Estate;

public class propitem {


        int background;
        String PropName;
        String PropType;

        public propitem(){}

        public propitem(int background, String PropName, String PropType){

            this.background = background;
            this.PropName	= PropName;
            this.PropType	= PropType;
        }

        public int getBackground() {
            return background;
        }

        public String getPropName() {
            return PropName;
        }

       public String getPropType() {
        return PropType;
    }

        public void setBackground(int background) {
            this.background = background;
        }

        public void setPropName(String PropName) {
            this.PropName = PropName;
        }

        public void setPropType(String PropType) {
        this.PropType = PropType;
    }

}


