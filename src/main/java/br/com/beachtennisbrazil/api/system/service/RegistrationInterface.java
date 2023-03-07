package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.app.dto.PlayerSystemAccessDto;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.system.entities.Register;

public interface RegistrationInterface {
    Boolean validateAdminRegistration(Register register);
    Boolean validatePlayerRegistration(PlayerSystemAccessDto dto);
    Register convertRegisterToLogin(Register register);

    PlayerSystemAccessDto convertPlayerSystemRegisterToPlayerLogin(Player player);






}
