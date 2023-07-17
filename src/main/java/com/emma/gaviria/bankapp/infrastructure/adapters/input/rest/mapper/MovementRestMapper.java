package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper;

import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.movement.MovementCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.movement.MovementUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.movement.MovementQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.movement.MovementResponse;
import org.mapstruct.Mapper;

@Mapper
public interface MovementRestMapper {

    Movement toMovementCreate(MovementCreateRequest movementCreateRequest);

    Movement toMovementUpdate(MovementUpdateRequest movementUpdateRequest);

    MovementResponse toMovementCreateResponse(Movement movement);

    MovementQueryResponse toMovementQueryResponse(Movement movement);


}
