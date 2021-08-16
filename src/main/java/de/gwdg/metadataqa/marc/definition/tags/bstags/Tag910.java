package de.gwdg.metadataqa.marc.definition.tags.bstags;

import de.gwdg.metadataqa.marc.definition.*;
import de.gwdg.metadataqa.marc.definition.general.codelist.RelatorCodes;
import de.gwdg.metadataqa.marc.definition.general.codelist.SubjectHeadingAndTermSourceCodes;
import de.gwdg.metadataqa.marc.definition.general.parser.LinkageParser;
import de.gwdg.metadataqa.marc.definition.general.parser.RecordControlNumberParser;
import de.gwdg.metadataqa.marc.definition.structure.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.structure.Indicator;
import de.gwdg.metadataqa.marc.definition.structure.SubfieldDefinition;

import static de.gwdg.metadataqa.marc.definition.FRBRFunction.*;

import java.util.Arrays;

/**
 * See From Tracing - Corporate Name [Deprecated]
 */
public class Tag910 extends DataFieldDefinition {

  private static Tag910 uniqueInstance;

  private Tag910() {
    initialize();
    postCreation();
  }

  public static Tag910 getInstance() {
    if (uniqueInstance == null)
      uniqueInstance = new Tag910();
    return uniqueInstance;
  }

  private void initialize() {
    tag = "910";
    label = "See From Tracing - Corporate Name [Deprecated]";
    mqTag = "CorporateNameSubject";
    cardinality = Cardinality.Repeatable;
    //setCompilanceLevels("O");

    ind1 = new Indicator();
    ind2 = new Indicator("Thesaurus")
      .setCodes(
        "0", "Bibbi autoriteter"
      )
      .setMqTag("thesaurus");


    setSubfieldsWithCardinality(
      "a", "Corporate name or jurisdiction name as entry element", "NR",
      "b", "Subordinate unit", "R",
      "c", "Location of meeting", "R",
      "d", "Date of meeting or treaty signing", "R",
      "e", "Relator term", "R",
      "f", "Date of a work", "NR",
      "g", "Miscellaneous information", "R",
      "h", "Medium", "NR",
      "k", "Form subheading", "R",
      "l", "Language of a work", "NR",
      "m", "Medium of performance for music", "R",
      "n", "Number of part/section/meeting", "R",
      "o", "Arranged statement for music", "NR",
      "p", "Name of part/section of a work", "R",
      "r", "Key for music", "NR",
      "s", "Version", "R",
      "t", "Title of a work", "NR",
      "u", "Affiliation", "NR",
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
