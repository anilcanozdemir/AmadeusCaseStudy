package com.amadeus.amadeuscasestudy.Controller;



import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDController<EntityDTO, EntitySaveRequestDto> {
    public ResponseEntity<Result> add(EntitySaveRequestDto entitySaveRequestDto);

    public ResponseEntity<DataResult<List<EntityDTO>>> getAll();

    public ResponseEntity<DataResult<EntityDTO>> getById(Long id);

    public ResponseEntity<Result> updateById(EntityDTO entityResponseDto);

    public ResponseEntity<DataResult<EntityDTO>> deleteById(Long id);
}
