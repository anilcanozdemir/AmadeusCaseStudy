package com.amadeus.amadeuscasestudy.ModelMapper;

public interface MapperProfile<EntityDto, EntitySaveRequestDto, Entity> {
    EntityDto EntityToDTO(Entity entity);

    Entity saveRequestDtoToEntity(EntitySaveRequestDto entitySaveRequestDto);

    Entity DTOtoEntity(EntityDto updateRequestDto);

}
