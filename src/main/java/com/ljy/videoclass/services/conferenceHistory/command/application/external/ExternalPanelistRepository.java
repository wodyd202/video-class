package com.ljy.videoclass.services.conferenceHistory.command.application.external;


import com.ljy.videoclass.services.panelist.command.application.model.Panelist;

import java.util.Optional;

public interface ExternalPanelistRepository {
    Optional<Panelist> getPanelist(String id);
}