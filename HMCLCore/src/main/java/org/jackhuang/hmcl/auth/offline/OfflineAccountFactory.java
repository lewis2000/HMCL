/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2018  huangyuhui <huanghongxun2008@126.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.auth.offline;

import org.jackhuang.hmcl.auth.AccountFactory;
import org.jackhuang.hmcl.auth.CharacterSelector;
import org.jackhuang.hmcl.util.UUIDTypeAdapter;

import java.net.Proxy;
import java.util.Map;

import static org.jackhuang.hmcl.util.DigestUtils.digest;
import static org.jackhuang.hmcl.util.Hex.encodeHexString;
import static org.jackhuang.hmcl.util.Lang.tryCast;

/**
 *
 * @author huangyuhui
 */
public class OfflineAccountFactory extends AccountFactory<OfflineAccount> {
    public static final OfflineAccountFactory INSTANCE = new OfflineAccountFactory();

    private OfflineAccountFactory() {
    }

    @Override
    public OfflineAccount create(CharacterSelector selector, String username, String password, Object additionalData, Proxy proxy) {
        return new OfflineAccount(username, getUUIDFromUserName(username));
    }

    @Override
    public OfflineAccount fromStorage(Map<Object, Object> storage, Proxy proxy) {
        String username = tryCast(storage.get("username"), String.class)
                .orElseThrow(() -> new IllegalStateException("Offline account configuration malformed."));
        String uuid = tryCast(storage.get("uuid"), String.class)
                .orElse(getUUIDFromUserName(username));

        // Check if the uuid is vaild
        UUIDTypeAdapter.fromString(uuid);

        return new OfflineAccount(username, uuid);
    }

    private static String getUUIDFromUserName(String username) {
        return encodeHexString(digest("MD5", username));
    }

}
