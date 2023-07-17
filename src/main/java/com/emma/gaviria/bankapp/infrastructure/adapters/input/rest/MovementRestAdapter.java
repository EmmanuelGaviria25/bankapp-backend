package com.emma.gaviria.bankapp.infrastructure.adapters.input.rest;

import com.emma.gaviria.bankapp.application.ports.input.movement.CreateMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.DeleteMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.GetMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.UpdateMovementUseCase;
import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.movement.MovementCreateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.request.movement.MovementUpdateRequest;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.movement.MovementQueryResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.movement.MovementResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.MovementRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Log4j2
public class MovementRestAdapter {

    private final CreateMovementUseCase createMovementUseCase;

    private final UpdateMovementUseCase updateMovementUseCase;

    private final GetMovementUseCase getMovementUseCase;

    private final DeleteMovementUseCase deleteMovementUseCase;

    private final MovementRestMapper movementRestMapper;

    @PostMapping(value = "/movements")
    public ResponseEntity<MovementResponse> createMovement(@RequestBody @Valid MovementCreateRequest movementCreateRequest) {
        Movement movement = movementRestMapper.toMovementCreate(movementCreateRequest);
        movement = createMovementUseCase.createMovement(movement);
        return new ResponseEntity<>(movementRestMapper.toMovementCreateResponse(movement), HttpStatus.CREATED);
    }

    @GetMapping(value = "/movements/{id}")
    public ResponseEntity<MovementQueryResponse> getMovement(@PathVariable Long id) {
        Movement movement = getMovementUseCase.getMovementById(id);
        MovementQueryResponse movementQueryResponse = movementRestMapper.toMovementQueryResponse(movement);
        return new ResponseEntity<>(movementQueryResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/movements")
    public ResponseEntity<MovementResponse> updateMovement(@RequestBody @Valid MovementUpdateRequest movementUpdateRequest) {
        Movement movement = movementRestMapper.toMovementUpdate(movementUpdateRequest);
        movement = updateMovementUseCase.updateMovement(movement);
        return new ResponseEntity<>(movementRestMapper.toMovementCreateResponse(movement), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/movements/{id}")
    public ResponseEntity<String> deleteMovement(@PathVariable Long id) {
        deleteMovementUseCase.deleteMovementById(id);
        return new ResponseEntity<>("Movement deleted", HttpStatus.OK);
    }

}
