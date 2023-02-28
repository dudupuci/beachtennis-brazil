package br.com.beachtennisbrazil.api.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public enum SystemRole {
    PLAYER_AUTHENTICATION("Player Authentication"),
    ADMIN_AUTHENTICATION("Admin Authentication");

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String slug;

    SystemRole(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }
}
