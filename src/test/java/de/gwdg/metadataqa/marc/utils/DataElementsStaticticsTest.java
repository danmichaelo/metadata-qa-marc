package de.gwdg.metadataqa.marc.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataElementsStaticticsTest {

  @Test
  public void testStatistics() {
    Counter<DataElementType> statistics = DataElementsStatictics.count();
    assertEquals(   8, statistics.keys().size());
    assertEquals(   6, statistics.get(DataElementType.controlFields));
    assertEquals( 226, statistics.get(DataElementType.controlFieldPositions));
    assertEquals( 222, statistics.get(DataElementType.coreFields));
    assertEquals( 178, statistics.get(DataElementType.coreIndicators));
    assertEquals(2464, statistics.get(DataElementType.coreSubfields));
    assertEquals( 189, statistics.get(DataElementType.localFields));
    assertEquals(  33, statistics.get(DataElementType.localIndicators));
    assertEquals(1001, statistics.get(DataElementType.localSubfields));
    assertEquals(4319, statistics.total());
  }

}