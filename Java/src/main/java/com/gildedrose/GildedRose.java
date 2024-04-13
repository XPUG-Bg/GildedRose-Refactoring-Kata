package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SELLIN = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items  ) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        boolean isNotAgedBrie = !item.name.equals(AGED_BRIE);
        boolean isNotSulfuras = !item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
        if (isNotSulfuras) {
            if (isNotAgedBrie) {
                if (!item.name.equals(BACKSTAGE_PASSAGE)) {
                    if (item.quality > MIN_QUALITY) {
                        item.quality = item.quality - 1;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;

                        if (item.name.equals(BACKSTAGE_PASSAGE)) {
                            if (item.sellIn < 11) {
                                if (item.quality < MAX_QUALITY) {
                                    item.quality = item.quality + 1;
                                }
                            }

                            if (item.sellIn < 6) {
                                if (item.quality < MAX_QUALITY) {
                                    item.quality = item.quality + 1;
                                }
                            }
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < MIN_SELLIN) {
                    if (!item.name.equals(BACKSTAGE_PASSAGE)) {
                        if (item.quality > MIN_QUALITY) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSAGE)) {
                        if (item.sellIn < 11) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < MIN_SELLIN) {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        } else {
            if (item.name.equals(BACKSTAGE_PASSAGE)) {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSAGE)) {
                        if (item.sellIn < 11) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (item.sellIn < MIN_SELLIN) {
                if (item.name.equals(BACKSTAGE_PASSAGE)) {
                    item.quality = item.quality - item.quality;
                }
            }
        }
    }

}
