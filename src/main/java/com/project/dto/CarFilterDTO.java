package com.project.dto;

public class CarFilterDTO {
    private String name;
    private Integer labelId;
    private Integer levelId;
    private int priceFrom;
    private int priceTo;

    public String getName() {
        return name;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public int getPriceFrom() {
        return priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public static Builder newBuilder() {
        return new CarFilterDTO().new Builder();
    }


    public class Builder {
        private Builder() {

        }


        public Builder setName(String name) {
            CarFilterDTO.this.name = name;
            return this;
        }

        public Builder setPriceFrom(int priceFrom) {
            CarFilterDTO.this.priceFrom = priceFrom;
            return this;
        }

        public Builder setPriceTo(int priceTo) {
            CarFilterDTO.this.priceTo = priceTo;
            return this;
        }

        public Builder setLabelId(Integer labelId) {
            CarFilterDTO.this.labelId = labelId;
            return this;
        }

        public Builder setLevelId(Integer levelId) {
            CarFilterDTO.this.levelId = levelId;
            return this;
        }


        public CarFilterDTO build() {
            return CarFilterDTO.this;
        }
    }
}
