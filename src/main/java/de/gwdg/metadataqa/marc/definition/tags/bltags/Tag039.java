package de.gwdg.metadataqa.marc.definition.tags.bltags;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.parser.LinkageParser;
import de.gwdg.metadataqa.marc.definition.general.validator.RegexValidator;

import static de.gwdg.metadataqa.marc.definition.FRBRFunction.*;

/**
 * National Bibliography Issue Number
 */
public class Tag039 extends DataFieldDefinition {

  private static Tag039 uniqueInstance;

  private Tag039() {
    initialize();
    postCreation();
  }

  public static Tag039 getInstance() {
    if (uniqueInstance == null)
      uniqueInstance = new Tag039();
    return uniqueInstance;
  }

  private void initialize() {

    tag = "039";
    label = "National Bibliography Issue Number";
    mqTag = "nationalBibliographyIssueNumber";
    cardinality = Cardinality.Nonrepeatable;
    // descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd037.html";
    // setCompilanceLevels("O");

    ind1 = new Indicator("National Bibliography Issue Number")
      .setCodes(
        "1", "British National Bibliography or British Catalogue of Music – Interim issue",
        "2", "British Catalogue of Music – Annual cumulation"
      )
      .setMqTag("source");

    ind2 = new Indicator();

    setSubfieldsWithCardinality(
      "a", "National bibliography issue number", "NR",
      "p", "Correction issue number", "NR"
    );

    getSubfield("a")
      .setValidator(new RegexValidator("^\\d\\d0[1-3]$"))
      .setMqTag("nationalBibliographyIssueNumber");

    getSubfield("p")
      .setMqTag("correctionIssueNumber");
  }
}
