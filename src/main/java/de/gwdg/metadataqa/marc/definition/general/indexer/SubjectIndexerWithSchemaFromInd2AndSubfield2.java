package de.gwdg.metadataqa.marc.definition.general.indexer;

import de.gwdg.metadataqa.marc.DataField;
import de.gwdg.metadataqa.marc.MarcSubfield;
import de.gwdg.metadataqa.marc.utils.keygenerator.DataFieldKeyGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectIndexerWithSchemaFromInd2AndSubfield2 implements FieldIndexer {

  @Override
  public Map<String, List<String>> index(DataField dataField, DataFieldKeyGenerator keyGenerator) {
    Map<String, List<String>> indexEntries = new HashMap<>();
    String schemaCode = dataField.getInd2();
    String schemaAbbreviation;
    if (schemaCode.equals("7")) {
      List<MarcSubfield> subfield2s = dataField.getSubfield("2");
      if (subfield2s == null || subfield2s.isEmpty())
        return indexEntries;

      schemaAbbreviation = subfield2s.get(0).getValue();
    } else {
      schemaAbbreviation = ClassificationSchemes.getInstance().resolve(dataField.resolveInd2());
    }

    String key = null;
    List<String> values = new ArrayList<>();
    for (MarcSubfield subfield : dataField.getSubfield("a")) {
      if (key == null)
        key = keyGenerator.forSubfield(subfield) + "_" + schemaAbbreviation;
      values.add(subfield.resolve());
    }
    indexEntries.put(key, values);

    return indexEntries;
  }

  private static SubjectIndexerWithSchemaFromInd2AndSubfield2 uniqueInstance;

  private SubjectIndexerWithSchemaFromInd2AndSubfield2() {}

  public static SubjectIndexerWithSchemaFromInd2AndSubfield2 getInstance() {
    if (uniqueInstance == null)
      uniqueInstance = new SubjectIndexerWithSchemaFromInd2AndSubfield2();
    return uniqueInstance;
  }
}
