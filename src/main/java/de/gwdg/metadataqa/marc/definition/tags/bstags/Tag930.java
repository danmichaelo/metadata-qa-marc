package de.gwdg.metadataqa.marc.definition.tags.bstags;

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
 * See From Tracing - Uniform Title [Deprecated]
 */
public class Tag930 extends DataFieldDefinition {

  private static Tag930 uniqueInstance;

  private Tag930() {
    initialize();
    postCreation();
  }

  public static Tag930 getInstance() {
    if (uniqueInstance == null)
      uniqueInstance = new Tag930();
    return uniqueInstance;
  }

  private void initialize() {

    tag = "930";
    label = "See From Tracing - Uniform Title [Deprecated]";
    mqTag = "SubjectAddedUniformTitle";
    cardinality = Cardinality.Repeatable;
    //setCompilanceLevels("O");

    ind1 = new Indicator();
    ind2 = new Indicator("Thesaurus")
      .setCodes(
        "0", "Bibbi autoriteter"
      )
      .setMqTag("thesaurus");

    setSubfieldsWithCardinality(
      "a", "Uniform title", "NR",
      "d", "Date of treaty signing", "R",
      "e", "Relator term", "R",
      "f", "Date of a work", "NR",
      "g", "Miscellaneous information", "R",
      "h", "Medium", "NR",
      "k", "Form subheading", "R",
      "l", "Language of a work", "NR",
      "m", "Medium of performance for music", "R",
      "n", "Number of part/section of a work", "R",
      "o", "Arranged statement for music", "NR",
      "p", "Name of part/section of a work", "R",
      "r", "Key for music", "NR",
      "s", "Version", "R",
      "t", "Title of a work", "NR",
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
}
