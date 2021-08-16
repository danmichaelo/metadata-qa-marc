package de.gwdg.metadataqa.marc.definition.tags.bstags;

import de.gwdg.metadataqa.marc.EncodedValue;
import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.general.parser.RecordControlNumberParser;
import de.gwdg.metadataqa.marc.definition.structure.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.structure.Indicator;
import de.gwdg.metadataqa.marc.definition.MarcVersion;
import de.gwdg.metadataqa.marc.definition.structure.SubfieldDefinition;
import de.gwdg.metadataqa.marc.definition.SourceSpecificationType;
import de.gwdg.metadataqa.marc.definition.general.codelist.RelatorCodes;
import de.gwdg.metadataqa.marc.definition.general.codelist.SubjectHeadingAndTermSourceCodes;
import de.gwdg.metadataqa.marc.definition.general.parser.LinkageParser;
import static de.gwdg.metadataqa.marc.definition.FRBRFunction.*;

import java.util.Arrays;

/**
 * See From Tracing - Topical Term [Deprecated]
 */
public class Tag950 extends DataFieldDefinition {

  private static Tag950 uniqueInstance;

  private Tag950() {
    initialize();
    postCreation();
  }

  public static Tag950 getInstance() {
    if (uniqueInstance == null)
      uniqueInstance = new Tag950();
    return uniqueInstance;
  }

  private void initialize() {

    tag = "950";
    label = "See From Tracing - Topical Term [Deprecated]";
    bibframeTag = "Topic";
    cardinality = Cardinality.Repeatable;
    //setCompilanceLevels("O");

    ind1 = new Indicator();
    ind2 = new Indicator("Thesaurus")
      .setCodes(
        "0", "Bibbi autoriteter"
      )
      .setMqTag("thesaurus");

    setSubfieldsWithCardinality(
      "a", "Topical term or geographic name entry element", "NR",
      "b", "Topical term following geographic name entry element", "NR",
      "c", "Location of event", "NR",
      "d", "Active dates", "NR",
      "e", "Relator term", "R",
      "g", "Miscellaneous information", "R",
      "v", "Form subdivision", "R",
      "x", "General subdivision", "R",
      "y", "Chronological subdivision", "R",
      "z", "Geographic subdivision", "R",
      "0", "Authority record control number or standard number", "R",
      "1", "Real World Object URI", "R",
      "2", "Source of heading or term", "NR",
      "3", "Materials specified", "NR",
      "4", "Relationship", "R",
      "6", "Linkage", "NR",
      "8", "Field link and sequence number", "R"
    );

    putVersionSpecificSubfields(MarcVersion.MARC21NO, Arrays.asList(
      new SubfieldDefinition("9", "Language code", "NR")
    ));
  }
}
