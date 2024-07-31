package uno.fastcampus.testdata.dto.request;

import uno.fastcampus.testdata.dto.TableSchemaDto;

import java.util.List;
import java.util.stream.Collectors;

public record TableSchemaRequest(
        String schemaName,
        String userId,
        List<SchemaFieldRequest> schemaFields
) {

    public TableSchemaDto toDto() {
        return TableSchemaDto.of(
                schemaName(),
                userId(),
                null,
                schemaFields.stream()
                        .map(SchemaFieldRequest::toDto)
                        .collect(Collectors.toUnmodifiableSet())
        );
    }

}
