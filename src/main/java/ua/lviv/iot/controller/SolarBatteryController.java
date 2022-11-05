package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.SolarBattery;
import ua.lviv.iot.dto.ClientDto;
import ua.lviv.iot.dto.SolarBatteryDto;
import ua.lviv.iot.dto.SolarPanelDto;
import ua.lviv.iot.dto.assembler.SolarBatteryDtoAssembler;
import ua.lviv.iot.service.SolarBatteryService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/solarBatteries")
public class SolarBatteryController {
    @Autowired
    private SolarBatteryService solarBatteryService;
    @Autowired
    private SolarBatteryDtoAssembler solarBatteryDtoAssembler;

    @GetMapping(value = "/{solarBatteryId}")
    public ResponseEntity<SolarBatteryDto> getSolarBattery(@PathVariable Integer solarBatteryId) {
        SolarBattery solarBattery = solarBatteryService.findById(solarBatteryId);
        SolarBatteryDto solarBatteryDto = solarBatteryDtoAssembler.toModel(solarBattery);
        return new ResponseEntity<>(solarBatteryDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SolarBatteryDto>> getAllSolarBatteries() {
        List<SolarBattery> solarBatterys = solarBatteryService.findAll();
        CollectionModel<SolarBatteryDto> solarBatteryDtos = solarBatteryDtoAssembler.toCollectionModel(solarBatterys);
        return new ResponseEntity<>(solarBatteryDtos, HttpStatus.OK);
    }

    @GetMapping(value = "ipAddresses/{ipAddressId}")
    public ResponseEntity<CollectionModel<SolarBatteryDto>> getSolarBatteriesByIpAddressesId(@PathVariable Integer ipAddessId) {
        List<SolarBattery> solarBatteries = solarBatteryService.findSolarBatteriesByIpAddressId(ipAddessId);
        Link selfLink =
                linkTo(methodOn(SolarBatteryController.class).getSolarBatteriesByIpAddressesId(ipAddessId)).withSelfRel();
        CollectionModel<SolarBatteryDto> solarBatteryDtos = solarBatteryDtoAssembler.toCollectionModel(solarBatteries,
                selfLink);
        return new ResponseEntity<>(solarBatteryDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<SolarBatteryDto> addSolarBattery(@RequestBody SolarBattery solarBattery) {
        SolarBattery newSolarBattery = solarBatteryService.create(solarBattery);
        SolarBatteryDto solarBatteryDto = solarBatteryDtoAssembler.toModel(newSolarBattery);
        return new ResponseEntity<>(solarBatteryDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{solarBatteryId}")
    public ResponseEntity<?> updateSolarBattery(@RequestBody SolarBattery uSolarBattery,
                                              @PathVariable Integer solarBatteryId) {
        solarBatteryService.update(solarBatteryId, uSolarBattery);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{solarBatteryId}")
    public ResponseEntity<?> deleteSolarBattery(@PathVariable Integer solarBatteryId) {
        solarBatteryService.delete(solarBatteryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
