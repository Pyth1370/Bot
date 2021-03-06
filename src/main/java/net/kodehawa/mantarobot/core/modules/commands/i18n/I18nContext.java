/*
 * Copyright (C) 2016-2018 David Alejandro Rubio Escares / Kodehawa
 *
 * Mantaro is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Mantaro is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mantaro.  If not, see http://www.gnu.org/licenses/
 */

package net.kodehawa.mantarobot.core.modules.commands.i18n;

import lombok.AllArgsConstructor;
import net.kodehawa.mantarobot.data.I18n;
import net.kodehawa.mantarobot.db.entities.helpers.GuildData;
import net.kodehawa.mantarobot.db.entities.helpers.UserData;

@AllArgsConstructor
public class I18nContext {
    private GuildData guildData;
    private UserData userData;

    public String get(String s) {
        I18n context = I18n.getForLanguage(getContextLanguage());
        return context.get(s);
    }

    public String withRoot(String root, String s) {
        I18n context = I18n.getForLanguage(getContextLanguage());
        return context.withRoot(root, s);
    }

    public String getContextLanguage() {
        String lang = userData.getLang() == null || userData.getLang().isEmpty() ? guildData.getLang() : userData.getLang();
        I18n context = I18n.getForLanguage(lang);
        return context == null ? "en_US" : lang;
    }
}
