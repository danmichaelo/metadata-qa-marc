package de.gwdg.metadataqa.marc.definition.tags.bstags;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.structure.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.structure.Indicator;
import de.gwdg.metadataqa.marc.definition.general.parser.LinkageParser;
import static de.gwdg.metadataqa.marc.definition.FRBRFunction.*;

/**
 * Utvidet informasjonskodefelt
 * Feltet stammer fra NORMARC og ble inkludert i MARC 21 i en overgangsperiode.
 * Biblioteksentralen faser det ut 31. desember 2022.
 */
public class Tag019 extends DataFieldDefinition {

  private static Tag019 uniqueInstance;

  private Tag019() {
    initialize();
    postCreation();
  }

  public static Tag019 getInstance() {
    if (uniqueInstance == null)
      uniqueInstance = new Tag019();
    return uniqueInstance;
  }

  private void initialize() {
    tag = "019";
    label = "Utvidet informasjonskodefelt [Deprecated]";
    mqTag = "UtvidetInformasjonskode";
    cardinality = Cardinality.Nonrepeatable;
    //setCompilanceLevels("O");

    ind1 = new Indicator();
    ind2 = new Indicator();

    setSubfieldsWithCardinality(
      "a", "Aldersgruppemerker for barnebøker", "NR",
      "b", "Dokumenttype", "NR",
      "d", "Litterær form/innhold", "NR",
      "e", "Litteratur tilpasset visse brukergrupper", "NR",
      "s", "Aldersgrense film/spill", "NR",
      "9", "Skoletrinn", "NR"
    );
  }
}
