package de.gwdg.metadataqa.marc.definition.tags.bstags;

import de.gwdg.metadataqa.marc.EncodedValue;
import de.gwdg.metadataqa.marc.dao.DataField;
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
 * See From Tracing - Personal Name [Deprecated]
 */
public class Tag900 extends DataFieldDefinition {

  private static Tag900 uniqueInstance;

  private Tag900() {
    initialize();
    postCreation();
  }

  public static Tag900 getInstance() {
    if (uniqueInstance == null)
      uniqueInstance = new Tag900();
    return uniqueInstance;
  }

  private void initialize() {
    tag = "900";
    label = "See From Tracing - Personal Name [Deprecated]";
    mqTag = "PersonalNameSubject";
    cardinality = Cardinality.Repeatable;
    //setCompilanceLevels("O");

    ind1 = new Indicator();
    ind2 = new Indicator("Thesaurus")
      .setCodes(
        "0", "Bibbi autoriteter"
      )
      .setMqTag("thesaurus");

    setSubfieldsWithCardinality(
      "a", "Personal name", "NR",
      "b", "Numeration", "NR",
      "c", "Titles and other words associated with a name", "R",
      "d", "Dates associated with a name", "NR",
      "e", "Relator term", "R",
      "f", "Date of a work", "NR",
      "g", "Miscellaneous information", "R",
      "h", "Medium", "NR",
      "j", "Attribution qualifier", "R",
      "k", "Form subheading", "R",
      "l", "Language of a work", "NR",
      "m", "Medium of performance for music", "R",
      "n", "Number of part/section of a work", "R",
      "o", "Arranged statement for music", "NR",
      "p", "Name of part/section of a work", "R",
      "q", "Fuller form of name", "NR",
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

    sourceSpecificationType = SourceSpecificationType.Indicator2AndSubfield2;
  }

  public String getSource(DataField field) {
    if (field.getInd2().equals("7")) {
      return field.getSubfield("2").get(0).getValue();
    }
    return getInd2().getCode(field.getInd2()).getLabel();
  }
}
